import React from 'react'
import ArticleCard from '../layout/ArticleCard';
import { useNavigate } from 'react-router-dom';

const ArticleList = (props) => {

    const { article } = props;

    const navigate = useNavigate();

    const navigateToNew = () => {
      // 👇️ navigate to /contacts
      navigate('/article/new');
    };

  return (
    <div className="container">
        <div>
            <button type="button" className="btn btn-primary" onClick={navigateToNew}>New</button>
        </div>
        <br />
            {
                article &&
                article.map((e, i) => {
                    return <ArticleCard key={i} id={e.id} title={e.title} content={e.content} />
                })
            }
    </div>
  )
}

export default ArticleList