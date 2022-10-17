<template>
<div class="container">
  <div class="row">
    <div class="col-3">
      <div class="card" style="margin-top: 20px">
        <div class="card-body">
          <img :src="$store.state.user.photo" alt="" style="width: 100%">
        </div>
      </div>
    </div>
    <div class="col-9">
      <div class="card" style="margin-top: 20px">
        <div class="card-header">
          <span style="font-size: 120%">题库</span>
        </div>
        <div class="card-body">
          <table class="table table-striped table-hover">
            <thead>
            <tr>
              <th>题目</th>
              <th>难度</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="problem in problems" :key="problem.id">
              <td>{{ problem.title }}</td>
              <td>{{ problem.difficulty }}</td>
            </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  </div>
</div>
</template>

<script>
import { ref } from "vue";
import $ from 'jquery'
import { useStore } from "vuex";

export default {
  setup() {
    const store = useStore();
    let problems = ref([]);

    const refresh_problem = () => {
      $.ajax({
        url: "http://127.0.0.1:3000/problem/getlistall/",
        type: "get",
        headers: {
          Authorization: "Bearer " + store.state.user.token,
        },

        success(resp) {
          problems.value = resp;
        }
      })
    }
    refresh_problem();
    return {
      problems
    }
  }

}
</script>

<style scoped>

</style>
