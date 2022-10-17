<template>
  <div class="container">
    <div class="row">
      <div class="col-5">
        <div class="card" style="margin-top: 20px">
          <div class="card-header"></div>
          <div class="card-body">
            
          </div>
        </div>
      </div>
      <div class="col-7">
        <div class="card" style="margin-top: 20px">
          <div class="card-header"></div>
          <div class="card-body">
            <VAceEditor
                v-model:value="content"
                @init="editorInit"
                lang="c_cpp"
                theme="textmate"
                style="height: 550px" />
            <div style="float: right">
              <button type="button" class="btn btn-danger" style="margin: 10px">逃跑</button>
              <button type="button" class="btn btn-warning" style="margin: 5px">执行代码</button>
              <button type="button" class="btn btn-success" style="margin: 5px">提交</button>
            </div>


          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { VAceEditor } from 'vue3-ace-editor';
import ace from 'ace-builds';
import { ref } from "vue";


export default {
  components: {
    VAceEditor
  },
  setup() {
    ace.config.set(
        "basePath",
        "https://cdn.jsdelivr.net/npm/ace-builds@" + require('ace-builds').version + "/src-noconflict/")
    let content = ref();

    return {
      content,
    }
  }



}
</script>

<style scoped>

</style>
