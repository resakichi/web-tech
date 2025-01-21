import { createApp } from 'vue';
import { createRouter, createWebHashHistory } from 'vue-router';
import axios from 'axios';
import studentsComponent from './components/studentsComponent.vue';
import addStudentComponent from './components/addStudentComponent.vue';

const studentsComponent = {
    template: `
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
    `,
    data() {
      return {
        students: []
      };
    },
    methods: {
      fetchStudents() {
        axios.get('http://localhost:8080/student/')
          .then(response => this.students = response.data)
          .catch(error => console.error('Error fetching students:', error));
      },
      deleteStudent(id) {
        axios.delete(`http://localhost:8080/student/${id}`)
          .then(() => this.fetchStudents())
          .catch(error => console.error('Error deleting student:', error));
      }
    },
    mounted() {
      this.fetchStudents();
    }
  };
  
  const addStudentComponent = {
    template: `
      <div>
        <h1>Add Student</h1>
        <form @submit.prevent="addStudent">
          <input v-model="student.name" placeholder="Name" required />
          <input v-model="student.surname" placeholder="Surname" required />
          <button type="submit">Save</button>
          <button @click="$router.push('/')">Cancel</button>
        </form>
      </div>
    `,
    data() {
      return {
        student: {
          name: '',
          surname: ''
        }
      };
    },
    methods: {
      addStudent() {
        axios.post('http://localhost:8080/student/', this.student)
          .then(() => this.$router.push('/'))
          .catch(error => console.error('Error adding student:', error));
      }
    }
  };
  
  const routes = [
    { path: '/', component: studentsComponent },
    { path: '/add', component: addStudentComponent }
  ];
  
  const router = VueRouter.createRouter({
    history: VueRouter.createWebHashHistory(),
    routes
  });
  
  const app = Vue.createApp({});
  app.use(router);
  app.mount('#app');
  