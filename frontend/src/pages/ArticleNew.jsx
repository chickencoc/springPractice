import React from 'react'

const ArticleNew = () => {

  

  return (
    <div className="row">
      <div className="col-lg-8">
          <article>
              <header style={{marginBottom: "10px"}}>
                  <label for="title1" className="form-label">제목</label>
                  <input type="text" className="form-control" id="title1" placeholder="제목을 입력하세요." />
              </header>
              <section style={{marginBottom: "10px"}}>
                  <label for="content1" className="form-label">내용</label>
                  <textarea className="form-control" id="content1" rows="3"></textarea>
              </section>
              <button type="button" className="btn btn-primary" id="create-btn">등록</button>
          </article>
      </div>
    </div>
  )
}

export default ArticleNew