<template>
  <div>
    <h1>Add Student</h1>
    <form @submit.prevent="addStudent">
      <input v-model="student.name" placeholder="Name" required />
      <input v-model="student.surname" placeholder="Surname" required />
      <input v-model="student.thirdName" placeholder="ThirdName" required />
      <button type="submit">Save</button>
      <button @click="$router.push('/')">Cancel</button>
    </form>

    <pre>{{ student }}</pre>
  </div>
</template>

<script>
import axios from 'axios';
import { ref } from 'vue';

export default {
  
  data() {
    return {
      student: {
        name: '',
        surname: '',
        thirdName: ''
      }
    };
  },
  methods: {
    addStudent() {
      console.log(this.student);
      /* 
      axios.post('http://localhost:8080/student/', this.student)
        .then(() => this.$router.push('/'))
        .catch(error => console.error('Error adding student:', error)); */
    }
  }
};
</script>

<style scoped>
/* Стили для компонента */
h1 {
  text-align: center;
}
form {
  margin-top: 20px;
}
input {
  display: block;
  margin: 10px 0;
  padding: 5px;
  font-size: 16px;
}
button {
  margin: 5px;
  padding: 5px 10px;
}
</style>
