function createAbilityList(pokemonObj) {
  const ul = document.createElement("ul");
  ul.className = "pokemon_abilities_ul";

  pokemonObj.abilities.forEach((item) => {
    const li = document.createElement("li");
    li.className = "pokemon_abilities_li";
    li.innerText = item.ability.name;
    ul.append(li);
  });

  return ul;
}

function createPokemonImage(pokemonObj) {
  const pokemonImage = document.createElement("img");
  pokemonImage.className = "pokemon_image";
  pokemonImage.src = pokemonObj.sprites.front_default;
  return pokemonImage;
}

function renderPokemon(pokemonData) {
  const content = document.getElementById("content");

  const pokemonDivContainer = document.createElement("div");
  pokemonDivContainer.className = "pokemon_div_container";

  const leftDiv = document.createElement("div");
  leftDiv.className = "pokemon_left_div";
  const pokemonName = document.createElement("h3");
  pokemonName.className = "pokemon_name";
  pokemonName.innerText = pokemonData.name;
  leftDiv.append(createPokemonImage(pokemonData), pokemonName);

  const rigthDiv = document.createElement("div");
  rigthDiv.className = "pokemon_rigth_div";

  const abilitiesСaption = document.createElement("p");
  abilitiesСaption.className = "pokemon_abilities_caption";
  abilitiesСaption.innerText = "Abilities";

  rigthDiv.append(abilitiesСaption, createAbilityList(pokemonData));

  pokemonDivContainer.append(leftDiv, rigthDiv);

  content.appendChild(pokemonDivContainer);
}

async function fetchPokemon() {
  const fetchResponse = await fetch("https://pokeapi.co/api/v2/pokemon?limit=50");
  const objWithResultArrayOfPokemons = await fetchResponse.json();
  const arrWithPokemons = objWithResultArrayOfPokemons.results;

  const arrayOfResponsesWithPokemonObjc = await Promise.all(arrWithPokemons.map(
    (pokemon) => fetch(pokemon.url)
  ));
  const pokemons = await Promise.all(arrayOfResponsesWithPokemonObjc.map(
    async (r) => r.json()
  ));
  pokemons.forEach((pokemon) => renderPokemon(pokemon));
}

async function main() {
  try {
    await fetchPokemon();
  } catch (error) {
    console.error(error);
  } finally {
    document.getElementById("preloader").classList.add("preloader--hide");
  }
}

main();
