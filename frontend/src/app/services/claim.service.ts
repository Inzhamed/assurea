import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Claim } from "../models/claim";

@Injectable({ providedIn: "root" })
export class ClaimService {
  private apiUrl = "http://localhost:8080/api/claims";
  constructor(private http: HttpClient) {}

  getAll(): Observable<Claim[]> {
    return this.http.get<Claim[]>(this.apiUrl);
  }

  create(claim: Claim): Observable<Claim> {
    return this.http.post<Claim>(this.apiUrl, claim);
  }

  update(id: number, claim: Claim): Observable<Claim> {
    return this.http.put<Claim>(`${this.apiUrl}/${id}`, claim);
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
