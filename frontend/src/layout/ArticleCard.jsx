import React from 'react'

const ArticleCard = ({id, title, content}) => {


    
  return (
    <>
        <div className="row-6">
            <div className="card">
                <div className="card-header">{id}</div>
                <div className="card-body">
                    <h5 className="card-title">{title}</h5>
                    <p className="card-text">{content}</p>
                    <a className="btn btn-primary">Побачити більше</a>
                </div>
            </div>
            <br />
        </div>
    </>
  )
}

export default ArticleCard