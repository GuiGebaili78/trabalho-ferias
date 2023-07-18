<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fintech FIAP</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

    <!-- Custom CSS -->
    <style>
        .navbar-brand {
            font-size: 24px;
            font-weight: bold;
        }

        .nav-link.dropdown-toggle::after {
            display: none;
        }

        .nav-link.dropdown-toggle:hover::after {
            display: inline-block;
        }

        /* Custom style for the "CLASSES" button */
        .nav-classes {
            background-color: #007bff; /* Blue color (you can change to any color you want) */
            color: #fff; /* White text color */
            margin-left: 30px; /* Distance from "Fintech FIAP" */
        }
    </style>
</head>

<body>
    <header class="bg-dark">
        <div class="container">
            <nav class="navbar navbar-expand-lg navbar-dark">
                <a class="navbar-brand" href="#">Fintech FIAP</a>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle nav-classes" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                            aria-haspopup="true" aria-expanded="false">
                            Classes
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="#">Categoria</a>
                            <a class="dropdown-item" href="#">Conta</a>
                            <a class="dropdown-item" href="#">Conta Corrente</a>
                            <a class="dropdown-item" href="#">Poupança</a>
                            <a class="dropdown-item" href="#">Investimento</a>
                            <a class="dropdown-item" href="#">Operações</a>
                            <a class="dropdown-item" href="#">Cartão de Crédito</a>
                            <a class="dropdown-item" href="#">Planejamento</a>
                            <a class="dropdown-item" href="#">Forma de Pagamento</a>
                        </div>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Login</a>
                    </li>
                </ul>
            </nav>
        </div>
    </header>

    <!-- Your content goes here -->

    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>
