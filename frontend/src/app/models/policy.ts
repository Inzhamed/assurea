import { Client } from './client';

export interface Policy {
  id?: number;
  client: Client;
  type: string;
  startDate: string;
  endDate?: string;
  amount: number;
}
