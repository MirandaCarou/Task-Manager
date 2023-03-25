import { Injectable } from '@angular/core';
import { Task } from './task/task';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  
  
  private apiUrl = 'http://localhost:8080';
  PATH: string = "default";

  constructor(private http: HttpClient) {
   }
  
  private httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json', 'Access-Control-Allow-Origin': '*' })
  };
  getTask(): Observable<Task> {
    return this.http.get<Task>(`${environment.API_URL}/${this.PATH}`);
  }

  getTasks(): Observable<Task[]> {
    return this.http.get<Task[]>(`${this.apiUrl}/task`, this.httpOptions);
  }
  
}
