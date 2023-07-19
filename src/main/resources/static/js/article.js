var createBtn = document.getElementById('create-btn');

if (createBtn) {
    createBtn.addEventListener('click', evt => {
        fetch("/api/articles", {
            method: 'POST',
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({
                title: document.getElementById('title1').value,
                content: document.getElementById('content1').value
            })
        }).then(data => {
            alert('등록 완료되었습니다.');
            location.replace('/');     // articles로 화면으로 이동
        })
    })
}