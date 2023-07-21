import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Header from './layout/Header'
import ArticleList from './pages/ArticleList';
import ArticleNew from './pages/ArticleNew';
import ArticleDetail from './pages/ArticleDetail';
import { useEffect, useState } from 'react';

function App() {
  
  const [article, setArticle] = useState();

  const articleListData = async () => {
    await fetch('/api/articles')
        .then(function(response) {
          return response.json();
        })
        .then(articles => {
          console.log('articles data :', articles);
          setArticle(articles);
        });
  }

  useEffect(() => {
    articleListData();
  }, []);
  

  return (
    <BrowserRouter>
      <Header />
      <div className='container'>
        <Routes>
          <Route path='/article' element={<ArticleList article={article} />} />
          <Route path='/article/new' element={<ArticleNew />} />
          <Route path='/article/:id' element={<ArticleDetail />} />
        </Routes>
      </div>
    </BrowserRouter>
  )
}

export default App;
