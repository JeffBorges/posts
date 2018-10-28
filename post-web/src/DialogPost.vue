<template>
  <v-dialog v-model="dialog" fullscreen hide-overlay transition="dialog-bottom-transition">
    <v-card>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn icon @click.native="close">
          <v-icon>close</v-icon>
        </v-btn>
      </v-card-actions>

      <v-container fill-height>
        <v-layout align-center>
          <v-flex>
            <h3 class="display-3">{{ post.titulo }}</h3>
            <span class="subheading">{{ post.subTitulo }}</span>
            <v-divider class="my-3"></v-divider>

              <div class="text-xs-center ma-5" v-if="!texto">
                <v-progress-circular
                        :size="100"
                        indeterminate
                        :width="7"
                        color="blue-grey darken-2">
                </v-progress-circular>
              </div>
            <v-scroll-x-transition>
              <div class="mb-3" v-if="texto" v-html="texto"></div>
            </v-scroll-x-transition>
            <v-divider class="my-3"></v-divider>

            <comentarios :id-post="post.id" v-if="post.id && dialog"></comentarios>
          </v-flex>
        </v-layout>
      </v-container>


    </v-card>
  </v-dialog>
</template>

<script>
  import Comentarios from "./Comentarios";
  export default {
    name: 'DialogPost',
    components: {Comentarios},
    props: {
      post: {},
    },
    data() {
      return {
        dialog: false,
        texto: null,
      };
    },
    methods: {
      open() {
        this.dialog = true;
        this.texto = null;
        this.carregarTexto();
      },
      carregarTexto() {
        setTimeout(() => {
          this.$http.get(`/post/${this.post.id}/texto`).then(response => {
            this.texto = response.data.texto;
          });
        }, 1E3)
      },
      close() {
        this.dialog = false;
      },
    },
  }
</script>

<style scoped>

</style>
