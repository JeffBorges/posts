<template>
  <v-flex xs12 sm6 md4 xl3>
    <v-card color="blue-grey darken-2"
            class="white--text">
      <v-card-title primary-title>
        <div class="headline">{{post.titulo}}</div>
        <div>{{post.subTitulo}}</div>
      </v-card-title>
      <v-divider light></v-divider>
      <v-card-actions>
        <v-btn flat dark @click="abrirPost">Ler</v-btn>
        <v-spacer></v-spacer>
        <v-badge left class="ma-1" v-if="quantidadeComentario">
          <span slot="badge">{{quantidadeComentario}}</span>
          <v-icon dark>comment</v-icon>
        </v-badge>
        <v-icon dark class="ma-1" v-else>comment</v-icon>
      </v-card-actions>
    </v-card>
  </v-flex>
</template>

<script>
  export default {
    name: 'CardPost',
    props: {
      post: {
        requires: true,
      },
    },
    data() {
      return {
        quantidadeComentario: 0,
      };
    },
    methods: {
      abrirPost() {
        this.$emit('lerPost', this.post)
      },
    },
    mounted() {
      this.$http.get(`/comentario/post/${this.post.id}/comentario/count`).then(response => {
        this.quantidadeComentario = response.data.quantidade;
      });
    },
  };
</script>
