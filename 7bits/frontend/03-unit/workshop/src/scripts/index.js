const urls = [
  "data1.json",
  "data2.json",
  "data3.json",
  "data4.json"
];

const renderItem = (item) => {
  const listItem = document.createDocumentFragment();

  const title = document.createElement("h2");
  title.className = "item__title";
  title.append(item.title);

  const description = document.createElement("p");
  description.className = "item__description";
  description.append(item.description);

  listItem.append(title);
  listItem.append(description);

  return listItem;
};

document.addEventListener("DOMContentLoaded", () => {
  const content = document.getElementsByClassName("content")[0];

  Promise.all(urls.map((url) => fetch(`../api/${url}`)))
    .then((arrOfResponses) => arrOfResponses.filter((response) => response.ok))
    .then((arrOfResponses) => arrOfResponses.map((response) => response.json()))
    .then((promises) => Promise.all(promises))
    .then((arrOfObjectsFromJSON) => arrOfObjectsFromJSON.forEach((obj) => {
      obj.data.forEach((item) => content.append(renderItem(item)));
    }))
    .catch((error) => console.error(error));
});
