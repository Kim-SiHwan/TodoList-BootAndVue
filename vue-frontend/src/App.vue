<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <todo-header msg="Welcome to Your Vue.js App"/>
    <todo-input @addItem="addItem"></todo-input>
    <todo-list v-bind:probsdata="items.data"
      @removeItem="removeItem"></todo-list>
  </div>
</template>

<script>
import TodoHeader from "@/components/TodoHeader.vue";
import TodoList from "@/components/TodoList.vue";
import TodoInput from "@/components/TodoInput";
import axios from "axios";

export default {
  name: 'App',
  data() {
    return {
      items: [],
    }
  },
  components: {
    'todo-header': TodoHeader,
    'todo-list': TodoList,
    'todo-input': TodoInput
  },
  methods: {
    addItem(item) {
      axios.post('todo/api',item).then(res=>{
        this.items = res.data;
      });
    },
    startApp() {
      axios.get('todo/').then(res => {
        this.items = res.data;
      })
    },
    removeItem(itemId,index){
      axios.delete('todo/'+itemId);
      this.items.data.splice(index,1);
    }
  },
  created() {
    this.startApp();
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
