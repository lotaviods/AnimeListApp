<?php
namespace App\Controller;

use App\Entity\Contatos;
use App\Repository\ContatosRepository;
use Symfony\Component\Console\Application;
use Symfony\Component\HttpFoundation\Request;
use Symfony\Component\HttpFoundation\Response;
use Symfony\Bundle\FrameworkBundle\Controller\AbstractController;

class ControllerHtml extends AbstractController
{
    public function index()
    {
        return $this->render('Index\Index.html.twig');
    }
    public function cadastrar()
    {
        return $this->render('Index\cadastro.html.twig');
    }

    public function editar()
    {
        return $this->render('Index\editar.html.twig');
    }

}
