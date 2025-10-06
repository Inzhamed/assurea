import { Policy } from './policy';

export interface Claim {
  id?: number;
  policy: Policy;
  date: string;
  description: string;
  status: 'OPEN' | 'IN_PROGRESS' | 'CLOSED';
}
