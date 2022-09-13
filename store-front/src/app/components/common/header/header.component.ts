import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  name = "Lafratta, Julian";
  role = "Administrador";
  sucursal = "Marcos Paz";

  constructor() { }

  ngOnInit(): void {
  }

}
