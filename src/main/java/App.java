import java.util.HashMap;

import java.util.Map;

import spark.ModelAndView;

import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

import java.util.ArrayList;

public class App{

    public static void main(String[] args){

        String layout = "templates/layout.vtl";

        //Get method for the homepage
        get("/", (request, response) -> {

            Map<String, Object> model = new HashMap<String, Object>();

            model.put("template", "templates/index.vtl");

            return new ModelAndView(model, layout);

        },new VelocityTemplateEngine());

        //Squad get and Post Methods
        get("/squads/new", (request, response) -> {

            Map<String, Object> model = new HashMap<String, Object>();

            model.put("template", "templates/squadForm.vtl");

            return new ModelAndView(model, layout);

        }, new VelocityTemplateEngine());

        //Get Method for Squads page
        get("/squad", (request, response) -> {

            Map<String, Object> model = new HashMap<String, Object>();

            model.put("squads", Squad.all());

            model.put("template", "templates/squads.vtl");

            return new ModelAndView(model, layout);

        }, new VelocityTemplateEngine());



        //Get method for hero Form
        get("/squads/:id/heros/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("template", "templates/heroForm.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //Post Method

        post("/squads", (request, response) -> {

            Map<String, Object> model = new HashMap<String, Object>();

            ArrayList<Squad> squads = request.session().attribute("squads");

            if (squads == null) {

                squads = new ArrayList<Squad>();

                request.session().attribute("squads", squads);

            }

            String squadName = request.queryParams("squadName");

            String squadCause = request.queryParams("squadCause");

            int squadSize = Integer.parseInt(request.queryParams("squadSize"));

            Squad mySquad = new Squad(squadName, squadCause, squadSize);

            squads.add(mySquad);

            model.put("template", "templates/squad-success.vtl");

            return new ModelAndView(model, layout);

        }, new VelocityTemplateEngine());

        //Post Method for Heros
        post("/heros", (request, response) ->{
            Map<String, Object> model = new HashMap<String, Object>();
            String heroName = request.queryParams("heroName");
            String heroPower = request.queryParams("heroPower");
            String heroWeakness = request.queryParams("heroWeakness");
            int heroAge = Integer.parseInt(request.queryParams("heroAge"));
            Hero myHero = new Hero(heroName,heroPower,heroAge,heroWeakness);
            model.put("template", "templates/hero-Success.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        get("/heros", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.queryParams("squadId")));
            String heroName = request.queryParams("heroName");
            String heroPower = request.queryParams("heroPower");
            String heroWeakness = request.queryParams("heroWeakness");
            int heroAge = Integer.parseInt(request.queryParams("heroAge"));
            Hero myHero = new Hero(heroName,heroPower,heroAge,heroWeakness);

            squad.addHero(myHero);

            model.put("squad", squad);
            model.put("template", "templates/squad-hero-success.vtl");

            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

        //Get Method for getting heros in the Squad
        get("/squads/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            Squad squad = Squad.find(Integer.parseInt(request.params(":id")));
            model.put("squad", squad);
            model.put("heros", Hero.getHeroList());
            model.put("template", "templates/squad.vtl");
            return new ModelAndView(model, layout);
        }, new VelocityTemplateEngine());

    }
}