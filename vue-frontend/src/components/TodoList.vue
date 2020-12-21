<template>
  <div class="listBox">
    <ul>
      <li v-for="(list,index) in probsdata" :key="index">
        <i class="checkBtn fas fa-check" aria-hidden="true"></i>
        {{ list.item }}
        <span class="removeBtn" type="button" @click="removeItem(list.itemId,index)">
                    <i class="far fa-trash-alt" aria-hidden="true"></i>
        </span>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "TodoList",
  props: ['probsdata'],
  methods: {
    removeItem(itemId, index) {
      this.$emit('removeItem', itemId, index);
    }
  }
}
</script>

<style>
.listBox{
  width: 500px; margin:auto;

}
ul {
  list-style-type: none;
  padding-left: 0px;
  margin-top: 0px;
  text-align: left;
}

li {
  display: flex;
  min-height: 50px;
  height: 50px;
  line-height: 50px;
  margin: 0.5rem 0;
  padding: 0 0.9rem;
  background-color: white;
  border-radius: 5px;
}

.checkBtn {
  line-height: 45px;
  color: #62acde;
  margin-left: 5px;

}

.removeBtn {
  margin-left: auto;
  color: #de4343;
}
</style>