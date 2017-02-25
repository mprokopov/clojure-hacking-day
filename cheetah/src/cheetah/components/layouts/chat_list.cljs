(ns cheetah.components.layouts.chat-list
  (:require [rum.core :as rum]
            [cheetah.components.base :as base]))

(rum/defc RoomItem [name]
  [:li.room-item
   [:a {:href (str "/rooms/" name)} name]])

(rum/defc Layout < rum/reactive [db]
  [:div.screen.rooms
   (base/Header {:title "Chat Rooms"})
   [:main
    [:ul.rooms-list
     (map RoomItem (keys (rum/react (rum/cursor-in db [:rooms]))))]]])
