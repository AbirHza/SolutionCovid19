import {Sexe} from "../Enum/sexe.enum";

export class SignupInfo {

  id: number;
  matricule: string;
  nom: string;
  prenom: string;
  email: string;
  sexe: Sexe;
  username: string;
  password: string;
  dateNaissance: Date;
  specialite: string;
  role: string[] = [];


  constructor(nom: string, prenom: string, username: string, dateNaissance: Date, specialite: string,
              matricule: string, email: string, password: string, sexe: Sexe) {
    this.nom = nom;
    this.prenom = prenom;
    this.dateNaissance = dateNaissance;
    this.username = username;
    this.email = email;
    this.password = password;
    // this.role = role;
    this.sexe = sexe;
    this.specialite = specialite;
    this.matricule = matricule;
  }

}
