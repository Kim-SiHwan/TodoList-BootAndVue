<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <todo-header msg="Welcome to Your Vue.js App"/>
    <todo-input @addItem="addItem"></todo-input>
    <todo-list v-bind:probsdata="items.data"
      @removeItem="removeItem"></todo-list>
    <todo-footer @clearItems="clearItems"></todo-footer>
  </div>
</template>

<script>
import TodoHeader from "@/components/TodoHeader.vue";
import TodoList from "@/components/TodoList.vue";
import TodoInput from "@/components/TodoInput";
import TodoFooter from "@/components/TodoFooter";
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
    'todo-input': TodoInput,
    'todo-footer': TodoFooter
  },
  methods: {
    addItem(item) {
      axios.post('todo/',item).then(res=>{
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
    },
    clearItems(){
      axios.delete('todo/');
      this.items=[];
    }
  },
  created() {
    this.startApp();
  }
}
</script>

<style>
body{
  text-align: center;
  background-color: #F6F6F8;
}
</style>
