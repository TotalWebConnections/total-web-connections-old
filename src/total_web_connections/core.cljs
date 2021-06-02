(ns ^:figwheel-hooks total-web-connections.core
  (:require
   [goog.dom :as gdom]
   [reagent.core :as reagent :refer [atom]]
   [reagent.dom :as rdom]
   [reitit.core :as r]
   [reitit.coercion.spec :as rss]
   [reitit.frontend :as rf]
   [reitit.frontend.controllers :as rfc]
   [reitit.frontend.easy :as rfe]
   [total-web-connections.utils.seo :as seo]
   [total-web-connections.pages.Home :refer [Home-page]]))

(println "This text is printed from src/nitor_fitness_site/core.cljs. Go ahead and edit it and see reloading in action.")
(defonce match (atom nil)) ; this is our current page - we define it here outside our normal data flow
(defn multiply [a b] (* a b))

;; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))

(defn get-app-element []
  (gdom/getElement "app"))

; (defn scroll-to-top []
;   "required or a link might put us halfway down a page - called on every route"
;   (.scrollTo js/window 0 0))
;
; (defn seo-header-setup [post]
;   (seo/set-seo-title post)
;   (seo/set-meta-desc post)
;   (seo/set-published-date post))
;
; (defn handle-post-page [view match post]
;   (seo-header-setup post)
;   (scroll-to-top)
;   [view match post])
;
; (defn handle-static-page [view match]
;   (seo-header-setup nil)
;   (scroll-to-top)
;   [view match])

(defn base-page []
  (let [view (:view (:data @match))
        post nil]
        ; {:keys [path query]} (:parameters @match)
        ; {:keys [uri]} path
        ; post (get-post-by-id uri)]
    (if post
      [view match post]
      ; (handle-post-page view @match post)
      (if view
        ; (handle-static-page view @match)
        [view match post]
        [Home-page])))) ; TODO 404 here

(def routes
  ["/"
   [""
    {:name      ::home
     :view      Home-page
     :link-text "Home"}]])


(defn mount [el]
  (rdom/render [base-page] el))

(def router
  (rf/router
    routes
    {:data {:coercion rss/coercion}}))

(defn on-navigate [new-match]
  (when new-match
    (reset! match new-match)))

(defn init-routes! []
  (js/console.log "initializing routes")
  (rfe/start!
    router
    on-navigate
    {:use-fragment false}))

(defn mount-app-element []
  (init-routes!)
  (when-let [el (get-app-element)]
    (mount el)))

;; conditionally start your application based on the presence of an "app" element
;; this is particularly helpful for testing this ns without launching the app
(mount-app-element)

;; specify reload hook with ^;after-load metadata
(defn ^:after-load on-reload []
  (mount-app-element))
  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)

