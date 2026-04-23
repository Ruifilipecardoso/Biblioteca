//div.campo_form

const linhas = document.querySelectorAll('.campo_form');

linhas.forEach(linha => {
    linha.addEventListener('click', () => {
        const input = linha.querySelector('input');
        if (input) {
            input.focus();
        }
    });
});