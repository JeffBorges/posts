<template>
  <div>
    <comentario v-for="(comentatio, index) in comentarios" :key="index" :comentario="comentatio"></comentario>
  </div>
</template>

<script>
  import Comentario from "./Comentario";
  export default {
    name: 'Comentarios',
    components: {Comentario},
    props: {
      idPost: null,
    },
    data() {
      return {
        comentarios: [],
      };
    },
    mounted() {
      this.$http.get(`comentario/post/${this.idPost}/comentario`).then(response => {
        this.comentarios = response.data;
      });
    },
  }
</script>

<style scoped>

</style>
