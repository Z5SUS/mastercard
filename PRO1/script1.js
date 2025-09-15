const box = document.querySelector(".box");
const center = document.querySelector(".center");

center.addEventListener("mousemove", (e) => {
  const rect = box.getBoundingClientRect();
  const x = e.clientX - rect.left; 
  const y = e.clientY - rect.top;  

  const midX = rect.width / 2;
  const midY = rect.height / 2;

  const rotateX = ((y - midY) / 20).toFixed(2);
  const rotateY = ((midX - x) / 20).toFixed(2);

  box.style.transform = `rotateX(${rotateX}deg) rotateY(${rotateY}deg)`;
});

center.addEventListener("mouseleave", () => {
  box.style.transform = "rotateX(0deg) rotateY(0deg)";
});
