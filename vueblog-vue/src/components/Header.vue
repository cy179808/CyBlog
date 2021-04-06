<template>
  <div class="m-content">
    <h3>欢迎来到CY的博客</h3>
    <div class="block">
      <el-avatar :size="50" :src="user.avatar"></el-avatar>
      <div>{{ user.usename }}</div>
    </div>

    <div class="maction">
      <el-link href="/blogs">主页</el-link>
      <el-divider direction="vertical"></el-divider>
      <span>
          <el-link type="success" href="/blog/add" :disabled="!hasLogin">发表文章</el-link>
        </span>
      <el-divider direction="vertical"></el-divider>
      <span v-show="!hasLogin">
          <el-link type="primary" href="/login">登陆</el-link>
        </span>
      <span v-show="hasLogin">
          <el-link type="danger" @click="logout">退出</el-link>
        </span>
    </div>
  </div>


</template>

<script>
export default {
  name: "Header",
  data() {
    return {
      hasLogin: false,
      user: {
        usename: '',
        avatar: ''
      }
    }
  },
  methods: {
    logout() {
      const _this = this
      this.$axios.get("/logout", {
        headers: {
          "Authorization": localStorage.getItem("token")
        }
      }).then((res) => {
        _this.$store.commit('REMOVE_INFO')
        _this.$router.push('/login')
      });
    }
  },
  created() {
    if (this.$store.getters.getUser.usename) {
      this.user.username = this.$store.getters.getUser.usename
      this.user.avatar = this.$store.getters.getUser.avatar
      this.hasLogin = true
    }
  }
}
</script>

<style scoped>
.m-content {
  margin: 0 auto;
  max-width: 960px;
  text-align: center;
}

</style>