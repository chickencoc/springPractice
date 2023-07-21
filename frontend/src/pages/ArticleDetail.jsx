import React from 'react'
import { useParams } from 'react-router-dom'
function ArticleDetail() {
  const { id } = useParams();

  return (
    <div>
        ArticleDetail : <strong>{id}</strong>
    </div>
  )
}

export default ArticleDetail