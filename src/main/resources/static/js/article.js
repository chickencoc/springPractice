var createBtn = document.getElementById('create-btn');

if (createBtn) {
    createBtn.addEventListener('click', evt => {
        fetch('/api/articles', {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            }
            body: JSON.stringfy({
                title: document.getElementById('title').value,
                content: document.getElementById('content').value
            })
        }).then(data => {
            alert("등록 완료되었습니다.");
            location.replace(articles); // articles로 화면 이동
        })
    })
}