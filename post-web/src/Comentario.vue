<template>
  <v-scroll-x-transition>
    <div class="my-3">
      <div class="my-3">
        <div class="headline">{{comentario.autor}}</div>
        <span class="grey--text">{{ converterDatas(comentario.dataInclusao) }}</span><br/>
        <span v-html="comentario.texto" class="my-3 subheading"></span>
      </div>
      <v-divider></v-divider>
    </div>
  </v-scroll-x-transition>
</template>

<script>
  import moment from 'moment';

  export default {
    name: 'Comentario',
    props: {
      comentario: null,
    },
    methods: {
      converterDatas(data) {
        return moment(data).format("DD/MM/YYYY HH:mm:SS");
      },
    },
  };
</script>

<style scoped>

</style>
