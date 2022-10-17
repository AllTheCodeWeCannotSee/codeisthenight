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
        <div class="card" style="margin-top: 20px;">
          <div class="card-header">
            <span style="font-size: 120%">题库</span>
            <button type="button" class="btn btn-primary float-end" data-bs-toggle="modal" data-bs-target="#add-problem-btn">
              新建题目
            </button>
            <!-- Modal -->
            <div class="modal fade" id="add-problem-btn" tabindex="-1">
              <div class="modal-dialog modal-xl">
                <div class="modal-content">
                  <div class="modal-header">
                    <h5 class="modal-title">新建题目</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                  </div>
                  <div class="modal-body">
                    <form>
                      <div class="mb-3">
                        <label for="add-problem-title" class="form-label">名称</label>
                        <input v-model="problemadd.title" type="text" class="form-control" id="add-problem-title" placeholder="请输入题目名称">
                      </div>
                      <div class="mb-3">
                        <label for="add-problem-pid" class="form-label">编号</label>
                        <input v-model="problemadd.problem_id" type="text" class="form-control" id="add-problem-pid" placeholder="请输入题目编号">
                      </div>

                      <div class="mb-3">
                        <label for="add-problem-time-limit" class="form-label">时间限制</label>
                        <input v-model="problemadd.time_limit" type="text" class="form-control" id="add-problem-time-limit" placeholder="请输入题目的时间限制">
                      </div>
                      <div class="mb-3">
                        <label for="add-problem-memory-limit" class="form-label">内存限制</label>
                        <input v-model="problemadd.memory_limit" type="text" class="form-control" id="add-problem-memory-limit" placeholder="请输入题目的内存限制">
                      </div>
                      <div class="mb-3">
                        <label for="add-problem-description" class="form-label">简介</label>
                        <textarea v-model="problemadd.description" class="form-control" id="add-problem-description" rows="3"></textarea>
                      </div>
                      <div class="mb-3">
                        <label for="add-problem-input" class="form-label">输入描述</label>
                        <textarea v-model="problemadd.input" class="form-control" id="add-problem-input" rows="3"></textarea>
                      </div>
                      <div class="mb-3">
                        <label for="add-problem-output" class="form-label">输出描述</label>
                        <textarea v-model="problemadd.output" class="form-control" id="add-problem-output" rows="3"></textarea>
                      </div>
                      <div class="mb-3">
                        <label for="add-problem-example" class="form-label">例子</label>
                        <textarea v-model="problemadd.example" class="form-control" id="add-problem-example" rows="4"></textarea>
                      </div>
                      <div class="mb-3">
                        <label for="add-problem-difficulty" class="form-label">题目难度</label>
                        <input v-model="problemadd.difficulty" type="text" class="form-control" id="add-problem-difficulty" placeholder="1-简单，2-中等，3-困难">
                      </div>
                      <div class="mb-3">
                        <label for="add-problem-hint" class="form-label">提示信息</label>
                        <input v-model="problemadd.hint" type="text" class="form-control" id="add-problem-hint" placeholder="请输入题目的提示信息">
                      </div>
                      <div class="mb-3">
                        <label for="add-problem-io-score" class="form-label">该题分值</label>
                        <input v-model="problemadd.io_score" type="text" class="form-control" id="add-problem-io-score" placeholder="请输入题目的分值">
                      </div>


                    </form>
                  </div>

                  <div class="modal-footer">
                    <div class="error-message">{{ problemadd.error_message }}</div>
                    <button type="button" class="btn btn-primary" @click="add_problem">创建</button>
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                  </div>
                </div>
              </div>
            </div>

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
                <td>
                  <button type="button" class="btn btn-secondary" style="margin-right: 10px" data-bs-toggle="modal" :data-bs-target="'#update-problem-modal-' + problem.id">修改</button>
                  <button type="button" class="btn btn-danger" @click="remove_problem(problem)">删除</button>

                  <div class="modal fade" :id="'update-problem-modal-' + problem.id" tabindex="-1">
                    <div class="modal-dialog modal-xl">
                      <div class="modal-content">
                        <div class="modal-header">
                          <h5 class="modal-title">新建题目</h5>
                          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <div class="mb-3">
                              <label for="add-problem-title" class="form-label">名称</label>
                              <input v-model="problem.title" type="text" class="form-control"  placeholder="请输入题目名称">
                            </div>
                            <div class="mb-3">
                              <label for="add-problem-pid" class="form-label">编号</label>
                              <input v-model="problem.problem_id" type="text" class="form-control"  placeholder="请输入题目编号">
                            </div>

                            <div class="mb-3">
                              <label for="add-problem-time-limit" class="form-label">时间限制</label>
                              <input v-model="problem.time_limit" type="text" class="form-control"  placeholder="请输入题目的时间限制">
                            </div>
                            <div class="mb-3">
                              <label for="add-problem-memory-limit" class="form-label">内存限制</label>
                              <input v-model="problem.memory_limit" type="text" class="form-control"  placeholder="请输入题目的内存限制">
                            </div>
                            <div class="mb-3">
                              <label for="add-problem-description" class="form-label">简介</label>
                              <textarea v-model="problem.description" class="form-control"  rows="3"></textarea>
                            </div>
                            <div class="mb-3">
                              <label for="add-problem-input" class="form-label">输入描述</label>
                              <textarea v-model="problem.input" class="form-control"  rows="3"></textarea>
                            </div>
                            <div class="mb-3">
                              <label for="add-problem-output" class="form-label">输出描述</label>
                              <textarea v-model="problem.output" class="form-control"  rows="3"></textarea>
                            </div>
                            <div class="mb-3">
                              <label for="add-problem-example" class="form-label">例子</label>
                              <textarea v-model="problem.example" class="form-control"  rows="4"></textarea>
                            </div>
                            <div class="mb-3">
                              <label for="add-problem-difficulty" class="form-label">题目难度</label>
                              <input v-model="problem.difficulty" type="text" class="form-control"  placeholder="1-简单，2-中等，3-困难">
                            </div>
                            <div class="mb-3">
                              <label for="add-problem-hint" class="form-label">提示信息</label>
                              <input v-model="problem.hint" type="text" class="form-control"  placeholder="请输入题目的提示信息">
                            </div>
                            <div class="mb-3">
                              <label for="add-problem-io-score" class="form-label">该题分值</label>
                              <input v-model="problem.io_score" type="text" class="form-control"  placeholder="请输入题目的分值">
                            </div>
                        </div>
                        <div class="modal-footer">
                          <div class="error-message">{{ problem.error_message }}</div>
                          <button type="button" class="btn btn-primary" @click="update_problem(problem)">保存修改</button>
                          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
                        </div>
                      </div>
                    </div>
                  </div>

                </td>
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
import { ref, reactive } from "vue";
import $ from 'jquery'
import { useStore } from "vuex";
import { Modal } from 'bootstrap/dist/js/bootstrap'

export default {
  setup() {
    const store = useStore();
    let problems = ref([]);

    const problemadd = reactive({
      title: "",
      problem_id: "",
      time_limit: "",
      memory_limit: "",
      description: "",
      input: "",
      output: "",
      example: "",
      difficulty: "",
      hint: "",
      io_score: "",
      error_message: "",
    })

    const refresh_problem = () => {
      $.ajax({
        url: "http://127.0.0.1:3000/problem/getlist/",
        type: "GET",
        headers: {
          Authorization: "Bearer " + store.state.user.token,
        },
        success(resp) {
          problems.value = resp;
        }
      })
    }
    refresh_problem();

    const add_problem = () => {
      problemadd.error_message = "";
      $.ajax({
        url: "http://127.0.0.1:3000/problem/add/",
        type: "post",
        data: {
          title: problemadd.title,
          problem_id: problemadd.problem_id,
          time_limit: problemadd.time_limit,
          memory_limit: problemadd.memory_limit,
          description: problemadd.description,
          input: problemadd.input,
          output: problemadd.output,
          example: problemadd.example,
          difficulty: problemadd.difficulty,
          hint: problemadd.hint,
          io_score: problemadd.io_score,
        },
        headers: {
          Authorization: "Bearer " + store.state.user.token,
        },
        success(resp) {
          if (resp.error_message === "success") {
            problemadd.title = "";
            problemadd.problem_id = "";
            problemadd.time_limit = "";
            problemadd.memory_limit = "";
            problemadd.description = "";
            problemadd.input = "";
            problemadd.output = "";
            problemadd.example = "";
            problemadd.difficulty = "";
            problemadd.hint = "";
            problemadd.io_score = "";
            Modal.getInstance("#add-problem-btn").hide();
            refresh_problem();
          } else {
            problemadd.error_message = resp.error_message;
          }
        }
      })
    }

    const remove_problem = (problem) => {
      $.ajax({
        url: "http://127.0.0.1:3000/problem/remove/",
        type: "post",
        data: {
          id: problem.id,
        },
        headers: {
          Authorization: "Bearer " + store.state.user.token,
        },
        success(resp) {
          if (resp.error_message === "success") {
            refresh_problem();
          }

        }
      })
    }
    const update_problem = (problem) => {
      problemadd.error_message = "";
      $.ajax({
        url: "http://127.0.0.1:3000/problem/update/",
        type: "post",
        data: {
          id: problem.id,
          title: problem.title,
          problem_id: problem.problem_id,
          time_limit: problem.time_limit,
          memory_limit: problem.memory_limit,
          description: problem.description,
          input: problem.input,
          output: problem.output,
          example: problem.example,
          difficulty: problem.difficulty,
          hint: problem.hint,
          io_score: problem.io_score,
        },
        headers: {
          Authorization: "Bearer " + store.state.user.token,
        },
        success(resp) {
          console.log(resp);
          if (resp.error_message === "success") {

            Modal.getInstance('#update-problem-modal-' + problem.id).hide();
            refresh_problem();
          } else {
            problemadd.error_message = resp.error_message;
          }
        }
      })
    }

    return {
      problems,
      problemadd,
      add_problem,
      remove_problem,
      update_problem
    }
  }
}
</script>

<style scoped>
div.error-message {
  color: red;
}
</style>
