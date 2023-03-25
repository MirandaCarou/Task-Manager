import { Component, OnInit } from '@angular/core';
import { Task } from './task';
import { TaskService } from '../task.service';

@Component({
  selector: 'task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.css']
})
export class TaskComponent implements OnInit {

  task!: Task;

  constructor(private taskService: TaskService) { }

  getTask() : void {
    this.taskService.getTask().subscribe(data => {
      this.task = data;
      console.log(data);
    });
  }

  ngOnInit(): void {
    this.getTask();
  }

}
