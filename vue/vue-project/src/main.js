import { createApp } from 'vue';
import { createRouter, createWebHashHistory } from 'vue-router';
import axios from 'axios';
//import studentsComponent from './components/studentsComponent.vue';
//import addStudentComponent from './components/addStudentComponent.vue';

const studentsComponent = {
    template: `
      <div>
      <h1>Students List</h1>
      <div class="listHead">
        <button @click="fetchStudents">Refresh</button>
        <button @click="showFilter = !showFilter">Filter</button>
        <div v-if="showFilter" class="form-container" style="display: flex; align-items: center; gap: 5px;">
          <input v-model="filterQuery" placeholder="Filter by name" />
          <button @click="filterStudents">Apply</button>
        </div>
      </div>
      <div class="list-container">
        <div class="list-item" v-for="student in students" :key="student.id">
          <span> {{ student.name }} {{ student.surname }} {{ student.thirdName }}</span>
          <button @click="deleteStudent(student.id)">Delete</button>
        </div>
      </div>
      <button @click="$router.push('/add')">Add Student</button>
    </div>
    `,
    data() {
      return {
        students: [],
        filterQuery: '',
        showFilter: false
      };
    },
    methods: {
      fetchStudents() {
          axios.get('http://localhost:8080/student/', {
            params: {parameter: ''}
          })
          .then(response => this.students = response.data)
          .catch(error => console.error('Error fetching students:', error));
      },
      deleteStudent(id) {
        axios.delete(`http://localhost:8080/student/${id}`)
          .then(() => this.fetchStudents())
          .catch(error => console.error('Error deleting student:', error));
      },
      filterStudents(){
        axios.get('http://localhost:8080/student/', {
          params: {parameter: this.filterQuery}
        })
          .then(response => this.students = response.data)
          .catch(error => console.error('Error fetching students:', error));
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
      <div class="form-container">
        <form @submit.prevent="addStudent">
          <input v-model="student.name" placeholder="Name" required />
          <input v-model="student.surname" placeholder="Surname" required />
          <input v-model="student.thirdName" placeholder="Third Name" required />
          <button type="submit">Save</button>
          <button type="button" @click="$router.push('/')">Cancel</button>
        </form>
      </div>

      <pre>{{ student }}</pre>
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
  