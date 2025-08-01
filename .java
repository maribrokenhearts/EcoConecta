async function carregar() {
  try {
    const resposta = await fetch("http://192.168.0.105/dados"); // Altere o IP se necessário
    const dados = await resposta.json();

    document.getElementById("temp").innerText = dados.temperatura;
    document.getElementById("umidar").innerText = dados.umidade_ar;
    document.getElementById("umisolo").innerText = dados.umidade_solo;

    // Verificar se está irrigando ou não
    const status = dados.umidade_solo < 40 ? "Ativada 💧" : "Desativada ✅";
    document.getElementById("irrigacao").innerText = status;
    
  } catch (erro) {
    alert("⚠️ Erro ao conectar com o dispositivo. Verifique a rede.");
    console.error(erro);
  }
}
