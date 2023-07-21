import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'

function Header() {


  return (
    <>
      <div className="p-4 mb-4 bg-light">
          <h1>Blog by React</h1>
          <h4>
              <span>Ласкаво просимо до блогу. </span>
              <button type="button" className="btn btn-danger">Вийти</button>
          </h4>
      </div>
    </>
  )
}

export default Header

