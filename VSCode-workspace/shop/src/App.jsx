import "./App.css";
import "bootstrap/dist/css/bootstrap.min.css";
import { useState } from "react";
import { Navbar, Container, Nav, Row, Col } from "react-bootstrap";
import data from "./data";
import { Routes, Route, Link } from "react-router-dom";

function App() {
  let [shoes] = useState(data);

  return (
    <div className="App">
      <Navbar bg="dark" data-bs-theme="dark">
        <Container>
          <Navbar.Brand href="#home">Navbar</Navbar.Brand>
          <Nav className="me-auto">
            <Nav.Link href="#home">Home</Nav.Link>
            <Nav.Link href="#features">Features</Nav.Link>
            <Nav.Link href="#pricing">Pricing</Nav.Link>
          </Nav>
        </Container>
      </Navbar>
      <Routes>
        <Route
          path="/"
          element={
            <>
              <div className="main-bg"> </div>
              <Container>
                <Row>
                  {shoes.map((a, i) => {
                    return <Card shoes={a} i={i + 1} />;
                  })}
                </Row>
              </Container>
            </>
          }
        />
        <Route path="/detail" element={<div>상세 페이지</div>} />
      </Routes>
    </div>
  );
}

function Card(props) {
  return (
    <Col>
      <img
        src={"https://codingapple1.github.io/shop/shoes" + props.i + ".jpg"}
        width="80%"
      />
      <h4>{props.shoes.title}</h4>
      <p>{props.shoes.content}</p>
    </Col>
  );
}

export default App;
