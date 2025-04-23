import { useState } from "react";
import "./App.css";

function App() {
  let [posts, setPosts] = useState([
    { title: "남자코트 추천", like: 0, date: "2024-01-01" },
    { title: "강남 우동맛집", like: 0, date: "2024-01-02" },
    { title: "파이썬 독학", like: 0, date: "2024-01-03" },
  ]);

  let [modal, setModal] = useState(false);
  let [modalTitle, setModalTitle] = useState(0);
  let [input, setInput] = useState("");

  return (
    <div className="App">
      <div className="black-nav">
        <h4>BLOG</h4>
      </div>

      {posts.map((a, i) => {
        return (
          <div className="list" key={i}>
            <h4
              onClick={() => {
                setModalTitle(i);
                setModal(!modal);
              }}
            >
              {a.title}{" "}
              <span
                onClick={(e) => {
                  e.stopPropagation();
                  let copy = [...posts];
                  copy[i].like++;
                  setPosts(copy);
                }}
              >
                {" "}
                👍
              </span>{" "}
              {a.like}
            </h4>
            <p>{a.date}</p>
            <button
              onClick={() => {
                let copy = [...posts];
                copy.splice(i, 1);
                setPosts(copy);
              }}
            >
              삭제
            </button>
          </div>
        );
      })}
      <input
        onChange={(e) => {
          setInput(e.target.value);
        }}
      />
      <button
        onClick={() => {
          if (input.trim() === "") {
            alert("내용을 입력하세요");

            return;
          }

          let today = new Date();
          let todayStr = `${today.getFullYear()}-${
            today.getMonth() + 1
          }-${today.getDate()}`;

          let copy = [...posts];
          copy.unshift({ title: input, like: 0, date: todayStr });
          setPosts(copy);
        }}
      >
        추가
      </button>
      {modal ? (
        <Modal posts={posts} modalTitle={modalTitle} color={"yellow"} />
      ) : null}
    </div>
  );
}

function Modal(props) {
  return (
    <div className="modal" style={{ background: props.color }}>
      <h4>{props.posts[props.modalTitle].title}</h4>
      <p>날짜</p>
      <p>상세내용</p>
    </div>
  );
}

export default App;
