import { Injectable } from '@angular/core';
import { Task } from './task/task';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  PATH: string = "default";

  constructor(private http: HttpClient) {
   }

  getTask(): Observable<Task> {
    return this.http.get<Task>(`${environment.API_URL}/${this.PATH}`);
  }
}
