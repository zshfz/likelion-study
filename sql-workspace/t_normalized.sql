CREATE TABLE Unnormalized_Students (
    student_id INT,
    name VARCHAR(50),
    phone_numbers VARCHAR(100)
);

-- 1NF: 하나의 컬럼에는 하나의 값만
CREATE TABLE Students_1NF (
    student_id INT,
    name VARCHAR(50),
    phone_number VARCHAR(20)
);

-- 2NF: 복합키 사용 시 부분 종속 제거
-- 비정규화 예: 과목명이 subject_id에만 종속됨
CREATE TABLE Enrollments_Unnormalized (
    student_id INT,
    subject_id INT,
    subject_name VARCHAR(50),
    score INT,
    PRIMARY KEY (student_id, subject_id)
);

-- 정규화된 테이블 분리
CREATE TABLE Enrollments_2NF (
    student_id INT,
    subject_id INT,
    score INT,
    PRIMARY KEY (student_id, subject_id)
);

CREATE TABLE Subjects (
    subject_id INT PRIMARY KEY,
    subject_name VARCHAR(50)
);

-- 3NF: 이행 종속 제거
-- 부서명이 부서ID에 종속, 사원테이블에서 제거 필요
CREATE TABLE Employees_Unnormalized (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    dept_id INT,
    dept_name VARCHAR(50)
);

-- 정규화된 테이블
CREATE TABLE Employees_3NF (
    emp_id INT PRIMARY KEY,
    emp_name VARCHAR(50),
    dept_id INT
);

CREATE TABLE Departments (
    dept_id INT PRIMARY KEY,
    dept_name VARCHAR(50)
);

-- BCNF: 모든 결정자가 후보키일 것
-- 교수는 강의실을 배정받지만, 강의실은 교수에만 종속 → 비정규 상태
CREATE TABLE ProfessorRoom_BCNF_Unnormalized (
    prof_id INT,
    room_id INT,
    course_id INT,
    PRIMARY KEY (prof_id, course_id)
);

-- 분해
CREATE TABLE ProfessorRoom (
    prof_id INT PRIMARY KEY,
    room_id INT
);

CREATE TABLE CourseAssignment (
    prof_id INT,
    course_id INT,
    PRIMARY KEY (prof_id, course_id)
);

-- 4NF: 다치 종속 제거
-- 학생이 여러 과목과 활동을 동시에 가짐
CREATE TABLE Student_Multivalued (
    student_id INT,
    subject VARCHAR(50),
    activity VARCHAR(50),
    PRIMARY KEY (student_id, subject, activity)
);

-- 분해
CREATE TABLE Student_Subject (
    student_id INT,
    subject VARCHAR(50),
    PRIMARY KEY (student_id, subject)
);

CREATE TABLE Student_Activity (
    student_id INT,
    activity VARCHAR(50),
    PRIMARY KEY (student_id, activity)
);

-- 5NF: 조인 종속 제거
-- 제품이 부품, 공급자, 지역에 따라 분해되는 구조
CREATE TABLE Product_5NF (
    product_id INT,
    component_id INT,
    supplier_id INT,
    region_id INT,
    PRIMARY KEY (product_id, component_id, supplier_id, region_id)
);

-- 분해 예
CREATE TABLE Product_Component (
    product_id INT,
    component_id INT,
    PRIMARY KEY (product_id, component_id)
);

CREATE TABLE Component_Supplier (
    component_id INT,
    supplier_id INT,
    PRIMARY KEY (component_id, supplier_id)
);

CREATE TABLE Supplier_Region (
    supplier_id INT,
    region_id INT,
    PRIMARY KEY (supplier_id, region_id)
);