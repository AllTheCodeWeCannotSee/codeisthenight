<template>
  <ContentField>bot</ContentField>
</template>

<script>
import ContentField from '../../../components/ContentField'
import $ from 'jquery'
import { useStore } from "vuex";

export default {
  components: {
    ContentField
  },
  setup() {

    const store = useStore();
    // $.ajax({
    //   url: "http://127.0.0.1:3000/problem/add/",
    //   type: "POST",
    //   data: {
    //     problem_id: "d0001",
    //     title: "两数之和",
    //     time_limit: "1000",
    //     memory_limit: "1000",
    //     description: "这是题目描述",
    //     input: "这是输入描述",
    //     output: "这是输出描述",
    //     examples: "这是测试用例",
    //     difficulty: "1",
    //     hint: "这是提示",
    //     io_score: "20"
    //   },
    //   headers: {
    //     Authorization: "Bearer " + store.state.user.token,
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error(resp) {
    //     console.log(resp);
    //   }
    // })
    // $.ajax({
    //   url: "http://127.0.0.1:3000/problem/remove/",
    //   type: "POST",
    //   data: {
    //     id: "1",
    //   },
    //   headers: {
    //     Authorization: "Bearer " + store.state.user.token,
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error(resp) {
    //     console.log(resp);
    //   }
    // })
    // $.ajax({
    //   url: "http://127.0.0.1:3000/problem/update/",
    //   type: "POST",
    //   data: {
    //     id: 4,
    //     problem_id: "d0002",
    //     title: "两数之差",
    //     time_limit: "1000",
    //     memory_limit: "1000",
    //     description: "这是题目描述",
    //     input: "这是输入描述",
    //     output: "这是输出描述",
    //     examples: "这是测试用例",
    //     difficulty: "1",
    //     hint: "这是提示",
    //     io_score: "20"
    //   },
    //   headers: {
    //     Authorization: "Bearer " + store.state.user.token,
    //   },
    //   success(resp) {
    //     console.log(resp);
    //   },
    //   error(resp) {
    //     console.log(resp);
    //   }
    // })
    // $.ajax({
    //     url: "http://127.0.0.1:3000/problem/getlist/",
    //     type: "GET",
    //
    //     headers: {
    //       Authorization: "Bearer " + store.state.user.token,
    //     },
    //     success(resp) {
    //       console.log(resp);
    //     },
    //     error(resp) {
    //       console.log(resp);
    //     }
    //   })

  }
}
</script>

<style scoped>

</style>
