<template>
  <v-app>
    <v-toolbar fixed app>
      <v-toolbar-title v-text="title"></v-toolbar-title>
    </v-toolbar>
    <v-content>
      <v-container fluid grid-list-lg>
          <v-layout row wrap>
            <card-post v-for="(post, index) in posts" :post="post" :key="index" @lerPost="lerPost"></card-post>
          </v-layout>
      </v-container>
    </v-content>
    <v-footer :fixed="fixed" app>
      <span>&copy; 2018</span>
    </v-footer>
    <dialog-post ref="dialogPost" :post="post"></dialog-post>
  </v-app>
</template>

<script>
  import CardPost from './CardPost';
  import DialogPost from './DialogPost';

  export default {
    components: {DialogPost, CardPost },
    data() {
      return {
        fixed: false,
        title: 'Posts Top Comentários',
        posts: [],
        post: {},
      };
    },
    methods: {
      lerPost(post) {
        this.post = post;
        this.$refs.dialogPost.open();
      },
    },
    mounted() {
      this.$http.get('/post').then(response => {
        this.posts = response.data;
      });
    },
  }
</script>
