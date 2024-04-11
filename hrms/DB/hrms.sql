-- Table: employees
CREATE TABLE employees (
    employee_id INT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL
);

-- Table: hr_staff
CREATE TABLE hr_staff (
    hr_id INT PRIMARY KEY,
    employee_id INT UNIQUE,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

CREATE TABLE logins (
    login_id INT PRIMARY KEY,
    username VARCHAR(50) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role ENUM('EMPLOYEE', 'HR') NOT NULL,
    employee_id INT,
    hr_id INT,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id) ON DELETE CASCADE,
    FOREIGN KEY (hr_id) REFERENCES hr_staff(hr_id) ON DELETE CASCADE
);


-- Table: attendance
CREATE TABLE attendance (
    attendance_id INT PRIMARY KEY,
    employee_id INT,
    check_in DATETIME NOT NULL,
    check_out DATETIME,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

-- Table: leave_requests
CREATE TABLE leave_requests (
    leave_request_id INT PRIMARY KEY,
    employee_id INT,
    start_date DATE NOT NULL,
    end_date DATE NOT NULL,
    status ENUM('PENDING', 'APPROVED', 'REJECTED') DEFAULT 'PENDING',
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

-- Table: complaints
CREATE TABLE complaints (
    complaint_id INT PRIMARY KEY,
    employee_id INT,
    complaint_text TEXT NOT NULL,
    resolution TEXT,
    status ENUM('OPEN', 'CLOSED') DEFAULT 'OPEN',
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);
ALTER TABLE complaints MODIFY COLUMN complaint_id INT AUTO_INCREMENT;
-- Table: queries
CREATE TABLE queries (
    query_id INT PRIMARY KEY,
    employee_id INT,
    query_text TEXT NOT NULL,
    response TEXT,
    status ENUM('OPEN', 'CLOSED') DEFAULT 'OPEN',
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);
ALTER TABLE queries MODIFY COLUMN query_id INT AUTO_INCREMENT;
-- Table: payroll_structure
-- Table: payroll_structure
CREATE TABLE payroll_structure (
    payroll_id INT PRIMARY KEY,
    employee_id INT,
    position VARCHAR(50) NOT NULL,
    base_salary DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);
ALTER TABLE payroll_structure MODIFY COLUMN payroll_id INT AUTO_INCREMENT;
-- Table: employee_bonus
CREATE TABLE employee_bonus (
    bonus_id INT PRIMARY KEY,
    employee_id INT,
    bonus_amount DECIMAL(10, 2) NOT NULL,
    bonus_reason TEXT,
    FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
);

-- Table: recruitment
CREATE TABLE recruitment (
    recruitment_id INT PRIMARY KEY,
    position VARCHAR(50) NOT NULL,
    interview_date DATETIME,
    candidate_email VARCHAR(100) NOT NULL,
    status ENUM('PENDING', 'HIRED', 'REJECTED') DEFAULT 'PENDING'
);

-- Table: interview_emails
CREATE TABLE interview_emails (
    interview_email_id INT PRIMARY KEY,
    recruitment_id INT,
    email_subject VARCHAR(255) NOT NULL,
    email_body TEXT NOT NULL,
    FOREIGN KEY (recruitment_id) REFERENCES recruitment(recruitment_id)
);

-- Table: candidates
CREATE TABLE candidates (
    candidate_id INT PRIMARY KEY,
    email VARCHAR(100) NOT NULL,
    full_name VARCHAR(100) NOT NULL,
    phone_number VARCHAR(20),
    resume_file_path VARCHAR(255) NOT NULL,
    status ENUM('PENDING', 'HIRED', 'REJECTED') DEFAULT 'PENDING'
);

-- Employees
INSERT INTO employees (employee_id, username, password, full_name, email) VALUES
(1, 'employee1', 'password1', 'John Doe', 'john@example.com'),
(2, 'employee2', 'password2', 'Jane Smith', 'jane@example.com');

-- HR Staff
INSERT INTO hr_staff (hr_id, employee_id, username, password) VALUES
(1, 1, 'hr1', 'hrpassword1'),
(2, 2, 'hr2', 'hrpassword2');

-- Logins (assuming employees and HR staff have the same usernames and passwords)
INSERT INTO logins (login_id, username, password, role, employee_id, hr_id) VALUES
(1, 'employee1', 'password1', 'EMPLOYEE', 1, NULL),
(2, 'employee2', 'password2', 'EMPLOYEE', 2, NULL),
(3, 'hr1', 'hrpassword1', 'HR', NULL, 1),
(4, 'hr2', 'hrpassword2', 'HR', NULL, 2);

-- Attendance (dummy data for employee 1)
INSERT INTO attendance (attendance_id, employee_id, check_in, check_out) VALUES
(1, 1, '2024-04-01 08:00:00', '2024-04-01 17:00:00'),
(2, 1, '2024-04-02 08:30:00', '2024-04-02 17:30:00');

-- Leave Requests (dummy data for employee 2)
INSERT INTO leave_requests (leave_request_id, employee_id, start_date, end_date, status) VALUES
(1, 2, '2024-04-03', '2024-04-05', 'PENDING'),
(2, 2, '2024-04-10', '2024-04-12', 'APPROVED');

-- Complaints (dummy data for employee 1)
INSERT INTO complaints (complaint_id, employee_id, complaint_text, resolution, status) VALUES
(1, 1, 'Printer not working', 'Replaced printer cartridge', 'CLOSED'),
(2, 1, 'Slow internet connection', NULL, 'OPEN');

-- Queries (dummy data for employee 2)
INSERT INTO queries (query_id, employee_id, query_text, response, status) VALUES
(1, 2, 'How to request a vacation?', 'You can submit a leave request through the HR portal.', 'CLOSED'),
(2, 2, 'Where can I find the employee handbook?', NULL, 'OPEN');

-- Payroll Structure
INSERT INTO payroll_structure (payroll_id, position, base_salary) VALUES
(1, 'Manager', 50000.00),
(2, 'Software Developer', 60000.00);

-- Employee Bonus (dummy data for employee 1)
INSERT INTO employee_bonus (bonus_id, employee_id, bonus_amount, bonus_reason) VALUES
(1, 1, 1000.00, 'Outstanding performance in Q1'),
(2, 1, 500.00, 'Completion of project ahead of schedule');

-- Recruitment
INSERT INTO recruitment (recruitment_id, position, interview_date, candidate_email, status) VALUES
(1, 'Marketing Coordinator', '2024-04-15 10:00:00', 'marketing@example.com', 'PENDING'),
(2, 'Sales Manager', '2024-04-20 14:00:00', 'sales@example.com', 'PENDING');

-- Interview Emails
INSERT INTO interview_emails (interview_email_id, recruitment_id, email_subject, email_body) VALUES
(1, 1, 'Interview Invitation for Marketing Coordinator Position', 'Dear Candidate, ...'),
(2, 2, 'Interview Invitation for Sales Manager Position', 'Dear Candidate, ...');

-- Candidates
INSERT INTO candidates (candidate_id, email, full_name, phone_number, resume_file_path, status) VALUES
(1, 'candidate1@example.com', 'Alice Johnson', '123-456-7890', '/resumes/candidate1_resume.pdf', 'PENDING'),
(2, 'candidate2@example.com', 'Bob Smith', '987-654-3210', '/resumes/candidate2_resume.pdf', 'HIRED');

