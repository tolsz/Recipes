# Recipes
Multi-user web service with Spring Boot that allows storing, retrieving, updating, and deleting recipes. Project from hyperskill.org.
Here's the link to the project:
<br />
<p align="center">
  <a href="https://hyperskill.org/projects/180">
    <img src="https://ictacademy.com.ng/wp-content/uploads/2020/02/1200px-JetBrains_Logo_2016.svg_.png" alt="Logo" height="80">
  </a>

<p align="center">Recipe Project, is a graduate project for the Java Backend Developer track.
<p align="center"><img src="https://img.icons8.com/color/30/000000/java-coffee-cup-logo--v1.png" alt="Java"><img src="https://img.icons8.com/color/30/000000/spring-logo.png" alt="Spring Framework"><img src="https://img.icons8.com/color/30/000000/postgreesql.png"/>
</p>

## Task Details
  <ol>
  <li><a href="Recipes/First recipe/readme.md">First Recipe</a>: Create a Spring Boot Project with Endpoints</li>
  <li><a href="Recipes/Multiple recipes/readme.md">Multiple Recipes</a>: Save and Delete recipes in memory</li>
  <li><a href="Recipes/Store a recipe/readme.md">Store a Recipe</a>: Save and Delete Recipes from a database</li>
  <li><a href="Recipes/Sort   update/readme.md">Sort & Update</a> : Filter results with queries</li>
  <li><a href="Recipes/More chefs to the table/readme.md">More Chefs to the table</a>: Learn User Authentication and authorization</li>
  </ol>

## Usage Examples
<strong>Example 1:</strong>
<code class="language-json">POST /api/register</code> request without authentication</p><pre><code class="language-json">{
   "email": "Cook_Programmer@somewhere.com",
   "password": "RecipeInBinary"
}</code></pre><p>
Status code: 200 (Ok)

<strong>Example 2:</strong>
<code class="language-json">POST /api/recipe/new</code> request without authentication</p><pre><code class="language-json">{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves", "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}</code></pre><p>
Status code: 401 (Unauthorized)

<strong>Example 3:</strong>
<code class="language-json"> POST /api/recipe/new</code> request with basic authentication; email (login): Cook_Programmer@somewhere.com, and password: RecipeInBinary</p><pre><code class="language-json">{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves", "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}</code></pre><p>
</code></pre><p>Response:</p><pre><code class="language-json">{
   "id": 1
}</code></pre><p>

<strong>Example 4:</strong>
<code class="language-json"> GET /api/recipe/1</code> request with basic authentication; email (login): Cook_Programmer@somewhere.com, and password: RecipeInBinary <br><br>Response:</br></p><pre><code class="language-json">{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "date": "2020-01-02T12:11:25.034734",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves", "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}</code></pre><p>

<strong>Example 5:</strong>
<code class="language-json"> PUT /api/recipe/1</code> request with basic authentication; email (login): Cook_Programmer@somewhere.com, and password: RecipeInBinary</p><pre><code class="language-json">{
   "name": "Fresh Mint Tea",
   "category": "beverage",
   "description": "Light, aromatic and refreshing beverage, ...",
   "ingredients": ["boiled water", "honey", "fresh mint leaves"],
   "directions": ["Boil water", "Pour boiling hot water into a mug", "Add fresh mint leaves", "Mix and let the mint leaves seep for 3-5 minutes", "Add honey and mix again"]
}</code></pre><p>
Status code: 204 (No Content)

<strong>Example 6:</strong>
After registering a new user with email: CamelCaseRecipe@somewhere.com, and password: C00k1es. \
<code class="language-json"> DELETE /api/recipe/1</code> request with basic authentication; email (login): CamelCaseRecipe@somewhere.com, password: C00k1es. 

Status code: 403 (Forbidden) \
Only the user who posted the recipe can delete or change it.
