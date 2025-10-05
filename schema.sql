-- Table des clients
CREATE TABLE clients (
  id SERIAL PRIMARY KEY,
  name VARCHAR(150) NOT NULL,
  email VARCHAR(150) UNIQUE,
  phone VARCHAR(30),
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table des polices
CREATE TABLE policies (
  id SERIAL PRIMARY KEY,
  client_id INT REFERENCES clients(id) ON DELETE CASCADE,
  type VARCHAR(80) NOT NULL,
  start_date DATE NOT NULL,
  end_date DATE,
  amount NUMERIC(12,2) CHECK (amount > 0)
);

-- Table des sinistres
CREATE TABLE claims (
  id SERIAL PRIMARY KEY,
  policy_id INT REFERENCES policies(id) ON DELETE CASCADE,
  date DATE DEFAULT CURRENT_DATE,
  description TEXT,
  status VARCHAR(20) CHECK (status IN ('OPEN','CLOSED','IN_PROGRESS'))
);
