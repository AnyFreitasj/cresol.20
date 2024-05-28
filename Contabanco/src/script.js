document.getElementById('accountForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const agencia = document.getElementById('agencia').value;
    const conta = document.getElementById('conta').value;
    const nome = document.getElementById('nome').value;

    document.getElementById('accountDetails').innerText = `Cliente: ${nome}\nAgência: ${agencia}\nConta: ${conta}`;
    document.getElementById('accountForm').style.display = 'none';
    document.getElementById('accountInfo').style.display = 'block';
});

let saldo = 2456.90;

function showOperation(type) {
    const operationLabel = document.getElementById('operationLabel');
    if (type === 'saque') {
        operationLabel.innerText = 'Digite o valor que deseja sacar:';
    } else if (type === 'deposito') {
        operationLabel.innerText = 'Digite o valor que deseja depositar:';
    }
    document.getElementById('operationForm').style.display = 'block';
    document.getElementById('operationValue').value = '';
    document.getElementById('operationValue').setAttribute('data-type', type);
}

function performOperation() {
    const operationValue = document.getElementById('operationValue');
    const value = parseFloat(operationValue.value);
    const type = operationValue.getAttribute('data-type');

    if (type === 'saque') {
        if (value <= saldo) {
            saldo -= value;
            alert('Saque realizado com sucesso.');
        } else {
            alert('Saldo insuficiente para realizar o saque.');
        }
    } else if (type === 'deposito') {
        saldo += value;
        alert('Depósito realizado com sucesso.');
    }

    document.getElementById('saldo').innerText = saldo.toFixed(2);
    document.getElementById('operationForm').style.display = 'none';
}
