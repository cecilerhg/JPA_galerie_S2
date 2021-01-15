/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  cecil
 * Created: 15 janv. 2021
 */

-- Initialisation spécifiques pour un jeu de test

INSERT INTO Galerie(id, nom, adresse) VALUES (1, 'Saatchi', 'King\''s Road, Londres');
INSERT INTO Exposition(id, debut, intitule, duree, organisateur_id) VALUES (1, now(), 'Expo Londres King', 5, 1);
