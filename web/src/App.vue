<template>
  <NavBar />
  <router-view></router-view>
</template>



<script>
import NavBar from "./components/NavBar";
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"
import $ from 'jquery'

export default {
  components: {
    NavBar
  },
  setup() {
    $.ajax({
      url: "http://127.0.0.1:3000/user/account/token/",
      type: "post",
      data: {
        username: 'Paul',
        password: 'ppp',
      },
      success(resp) {
        console.log(resp);
      },
      error(resp) {
        console.log(resp);
      }
    });
    $.ajax({
      url: "http://127.0.0.1:3000/user/account/info/",
      type: "get",
      headers: {
        Authorization: "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJkOTM3ZjQ1NDRlODY0NGQ1YWVlMjViN2VmZWVkODcyMSIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTY2NTM4MzUxMCwiZXhwIjoxNjY2NTkzMTEwfQ.wgusIojawVLqSYwdmNxNzVgJIDbWDtuyVgCth9RhcG0"
      },
      success(resp) {
        console.log(resp);
      },
      error(resp) {
        console.log(resp);
      }
    });
    $.ajax({
      url: "http://127.0.0.1:3000/user/account/register/",
      type: "post",
      data: {
        username: 'Cup',
        password: 'pcup',
        confirmedPassword: 'pcup',
      },
      success(resp) {
        console.log(resp);
      },
      error(resp) {
        console.log(resp);
      }
    });
  }
}
</script>


<style>
body {
  background-image: url("./assets/images/background.jpg");
  background-size: cover;
}
</style>
