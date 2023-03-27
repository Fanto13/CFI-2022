//inizializzo il vettore delle parole da trovare
const Parole = [
  "gatto",
  "pesce",
  "stato",
  "mappa",
  "festa",
  "pasta",
  "tempo",
  "pesce",
  "fiume",
  "scena",
  "aroma",
  "gioco",
  "tetto",
  "tigre",
  "verde",
  "vista",
];
const lingoBoard = document.getElementById("lingo-board");
//tentativi rimasti
const attemptsLeft = document.getElementById("attempts");
let parolaSegreta, attempts, tentativi, griglia;
let giocoFinito = false;
// genera una parola italiana di 5 lettere casualmente
function generateWord() {
  // genera un numero casuale tra 0 e la lunghezza del vettore delle parole
  const randomIndex = Math.floor(Math.random() * Parole.length);
  return Parole[randomIndex].toUpperCase();
}
// inizializza un nuovo gioco
function newGame() {
  //tentativi da 5 a 0
  attempts = 5;
  //tentativi da 0 a 5
  tentativi = 0;
  griglia = 5;
  giocoFinito = false;
  parolaSegreta = generateWord();
  console.log("Parola segreta:", parolaSegreta);
  let boardHTML = "";

  for (let  i= 0; i < griglia*griglia; i++) {
    boardHTML += "<div> </div>";
  }
  lingoBoard.innerHTML = boardHTML;
  // resetta il numero di tentativi rimasti
  document.getElementById("guess").value = "";
}
// controlla l'input dell'utente e aggiorna di conseguenza il gioco
function checkGuess() {

  // controlla se il gioco è finito
  if (giocoFinito) {
    return "Il gioco è finito";
  }
  // controlla se l'input è valido
  const guess = document.getElementById("guess").value.toUpperCase();
  // controlla se l'input è una parola di 5 lettere
  if (!/^[a-zA-Z]{5}$/.test(guess)) {
    alert("Inserisci una parola di 5 lettere valida");
    return;
  }
  // aggiorna il numero di tentativi rimasti
  attempts--;
  
  attemptsLeft.textContent = attempts;
  // controlla se l'utente ha indovinato la parola segreta
  let correctPos = 0,
    correctLet = 0;

  for (let i = 0; i < griglia; i++) {
    console.log(tentativi);
    if (guess[i] === parolaSegreta[i]) {
      // controlla se l'utente ha indovinato la posizione
      lingoBoard.children[i+(tentativi*5)].classList.add("corretta");
      lingoBoard.children[i+(tentativi*5)].textContent = guess[i];
      //incrementa il numero di posizioni corrette
      correctPos++;
      // controlla se l'utente ha indovinato la lettera
    } else if (parolaSegreta.includes(guess[i])) {
      lingoBoard.children[i+(tentativi*5)].classList.add("sbagliata");
      
      lingoBoard.children[i+(tentativi*5)].textContent = guess[i];
      //incrementa il numero di lettere corrette
      correctLet++;
    }
  }
  // controlla se il gioco è finito
  if (correctPos === 5) {
    alert("Congratulazioni, hai vinto!");
    giocoFinito = true;
    //se l'utente ha finito i tentativi
  } else if (attempts === 0) {
    alert(`Hai perso!!! The Parola segreta era: ${parolaSegreta}`);
    giocoFinito = true;
    //se l'utente ha sbagliato, dai un suggerimento sulle posizioni da cambiare
  } else {
    alert(
     
      `Correggi le lettere nella posizione: ${correctLet}, e le lettere sbagliate nella posizione: ${correctPos}`
    );
  }
  tentativi++;
}
// Event listeners  per il bottone invio
document.getElementById("submit").addEventListener("click", checkGuess);
// controlla se l'utente ha premuto il tasto invio
document.getElementById("guess").addEventListener("keydown", (event) => {
  if (event.key === "Enter") {
    checkGuess();
  }
});
// crea un nuovo gioco
newGame();
