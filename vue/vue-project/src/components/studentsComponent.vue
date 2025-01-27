<template>
  <div>
    <h1>Students List</h1>
    <button @click="fetchStudents">Refresh</button>
    <ul>
      <li v-for="student in students" :key="student.id">
        {{ student.name }} {{ student.surname }}
        <button @click="deleteStudent(student.id)">Delete</button>
      </li>
    </ul>
    <button @click="$router.push('/add')">Add Student</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      students: [],
    };
  },
  methods: {
    fetchStudents() {
      axios.get('http://localhost:8080/student/')
        .then(response => (this.students = response.data))
        .catch(error => console.error('Error fetching students:', error));
    },
    deleteStudent(id) {
      axios.delete(`http://localhost:8080/student/${id}`)
        .then(() => this.fetchStudents())
        .catch(error => console.error('Error deleting student:', error));
    },
  },
  mounted() {
    this.fetchStudents();
  },
};
</script>
