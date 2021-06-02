(ns total-web-connections.pages.Home
  (:require [total-web-connections.components.hero :refer [Hero-svg]]))

(defn Home-page []
  [:div.Home
   [:div.Home__hero
    [:div.Home__hero__text
     [:div.Home__hero__text__content
      [:h1.red-text.text-h2 "Welcome"]
      [:h1.text-h2 "We Build Beautiful Sites And Rock Solid Applications"]
      [:h1.text-h2 "Let's Get Started!"]]]
    [Hero-svg]]
   [:div.Home__about.section.maxWidth
    [:h2 "ENABLING BUSINESSES TO DO MORE."]
    [:p.text-h4 "Total Web Connections is a bespoke software development partner in the Chicago suburbs. We offer services to small and mid sized businsses looking to streamline their operations through custom software."]]
   [:div.Home__services.section.maxWidth
      [:h3.blue-underline "What We Do"]
      [:div.flex-row
       [:div.col
        [:h4 "Website Development"]]
       [:div.col
        [:h4 "Application Development"]]
       [:div.col
        [:h4 "Mobile Apps"]]
       [:div.col
        [:h4 "Content Marketing"]]]]
   [:div.Home__callout
    [:h2 "Start Your Journey To a Better Web."]]
   [:div.Home__projects.section.maxWidth
    [:h3.blue-underline "What We've Done"]]])


